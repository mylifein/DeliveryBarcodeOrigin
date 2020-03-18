package com.chenbro.deliverybarcode;

import static org.junit.Assert.assertTrue;

import com.chenbro.deliverybarcode.model.HubDepartment;
import com.chenbro.deliverybarcode.service.IHubDepartmentService;
import com.chenbro.deliverybarcode.service.impl.HubDepartmentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */

public class AppTest 
{


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void save(){
        IHubDepartmentService hubDepartmentService = new HubDepartmentServiceImpl();
        HubDepartment hubDepartment = new HubDepartment();
        hubDepartment.setCity("广州");
        hubDepartment.setCreateBy("C8777");
        hubDepartment.setDeptCode("D001");
        hubDepartment.setDeptName("资讯部");
        hubDepartmentService.insert(hubDepartment);
    }
}
