package com.xhsmart.ssmcxf.task;

import HSM.SafeNet;
import HSM.Status;
import com.xhsmart.ssmcxf.entity_16.Ik_16;
import com.xhsmart.ssmcxf.mapper_16.IkMapper_16;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component()
public class GenerateKey_16 {

    /**
     * 注入数据访问对象
     */
    @Resource(name = "ikMapper_16")
    private IkMapper_16 ikMapper16;

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
        Ik_16 ik=new Ik_16();
        try {
            int count=ikMapper16.count_16();
            for (int currentData=count; currentData<200000;) {
                System.out.print("16_16_16");
                s = hsm.GetRandom(16);
                if (s.ErrCode == 0) {
                    System.out.println("random count :: "+count+"  Get random from HSM ::" +(++i)+"::"
                            + s.OutValue+"yet need ::"+(200000-count)+"  full ");
                    ik.setKey(s.OutValue);
                    ikMapper16.save_16(ik);
                } else {
                    System.out.println("Get random from HSM failed ::"  + (++i)+":: "
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
