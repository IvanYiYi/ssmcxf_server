package com.xhsmart.ssmcxf.task;

import HSM.SafeNet;
import HSM.Status;
import com.xhsmart.ssmcxf.entity_8.Ik_8;
import com.xhsmart.ssmcxf.mapper_8.IkMapper_8;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component()
public class GenerateKey_8 {

    /**
     * 注入数据访问对象
     */
    @Resource(name = "ikMapper_8")
    private IkMapper_8 ikMapper;

    int i;

    @Scheduled(cron = "*/1 * * * * ?")
    public void generateKey() throws InterruptedException {
        int rv;
        Status s;
        SafeNet hsm = new SafeNet();

        rv = hsm.Init("KMC", "abcd1234");
        if (rv != 0) {
            System.out.println("Call HSM failed:" + hsm.GetErrMsg());
            return;
        }

        rv = hsm.Connect();
        if (rv != 0) {
            System.out.println("Call HSM failed:" + hsm.GetErrMsg());
            return;
        }
        Ik_8 ik=new Ik_8();
        try {
            int count=ikMapper.count_8();
            for (int currentData=count; currentData<200000;) {

                System.out.print("888888");
                s = hsm.GetRandom(8);
                if (s.ErrCode == 0) {
                    System.out.println("random count :: "+count+"  Get random from HSM ::" +(++i)+"::"
                            + s.OutValue+"yet need ::"+(200000-count)+"   full ");
                    ik.setKey(s.OutValue);
                    ikMapper.save_8(ik);
                } else {
                    System.out.println("Get random from HSM failed ::"  + (++i)+"::"
                            + s.ErrCode);// + s.ErrMsg);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        hsm.Disconnect();
    }
}
