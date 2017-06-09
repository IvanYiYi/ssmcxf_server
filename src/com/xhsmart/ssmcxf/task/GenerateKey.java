package com.xhsmart.ssmcxf.task;

import HSM.SafeNet;
import HSM.Status;
import com.xhsmart.ssmcxf.entity.Ik;
import com.xhsmart.ssmcxf.mapper.IkMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component()
public class GenerateKey {

    /**
     * 注入数据访问对象
     */
    @Resource(name = "ikMapper")
    private IkMapper ikMapper;

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

        try {
            int count=ikMapper.count();
            for (int currentData=count; currentData<200000;) {
                s = hsm.GetRandom(16);
                if (s.ErrCode == 0) {
                    System.out.println("random count :: "+count+"  Get random from HSM ::" +(++i)+":: "
                            + s.OutValue+"yet need ::"+(200000-count)+"  full ");
                    Ik ik=new Ik();
                    ik.setKey(s.OutValue);
                    ikMapper.save(ik);

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

      //  System.out.println("hello");
    }
}
