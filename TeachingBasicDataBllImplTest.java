package com.iflytek.cycore.usercenter.bll;

import com.iflytek.cycore.usercenter.bll.api.TeachingBasicDataBll;
import com.iflytek.cycore.usercenter.dto.EduSystem;
import com.iflytek.cycore.usercenter.dto.Subject;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;


@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class TeachingBasicDataBllImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private TeachingBasicDataBll teachingBasicDataBll;

    @Test
    public void testQueryPhaseByName() throws Exception {
        logger.info(teachingBasicDataBll.queryPhaseByName(""));
    }

    @Test
    public void testQueryPhaseById() throws Exception {
        logger.info(teachingBasicDataBll.queryPhaseById("03"));
    }

    @Test
    public void testQueryGradeByName() throws Exception {
        logger.info(teachingBasicDataBll.queryGradeByName(""));
    }

    @Test
    public void testQueryGradeById() throws Exception {
        logger.info(teachingBasicDataBll.queryGradeById("03"));
    }


    @Test
    public void testQuerySubjectByName() throws Exception {
        logger.info(teachingBasicDataBll.querySubjectByName(""));
    }

    @Test
    public void testQuerySubjectById() throws Exception {
        logger.info(teachingBasicDataBll.querySubjectById("1100006"));
    }

    @Test
    @Rollback(value = true)
    public void testAddSubject() throws Exception {
        Subject subject = new Subject();
        subject.setSubjectId("11111");
        subject.setSubjectName("数学1");
        subject.setRemark("数学学科");
        teachingBasicDataBll.addSubject(subject);
    }

    @Test
    public void testIsSubjectNameExists() throws Exception {
        Subject subject = new Subject();
        subject.setSubjectName("math");
        subject.setRemark("math subject");
        teachingBasicDataBll.isSubjectNameExists("test111");
    }

    @Test
    @Rollback(value = true)
    public void testModifySubject() throws Exception {
        Subject subject = new Subject();
        subject.setSubjectName("数学");
        subject.setRemark("math subject modified");
        subject.setSubjectId("02");
        teachingBasicDataBll.modifySubject(subject);
    }

    @Test
    public void testQueryEduSystem() throws Exception {
        List<EduSystem> eduSystem = teachingBasicDataBll.queryEduSystemByPhaseId("-1");
    }

//    @Test
//    @Rollback(value = true)
//    public void testAddEduSystem() throws Exception {
//        EduSystem eduSystem = new EduSystem();
//        eduSystem.setEduSystemName("test_system");
//        eduSystem.setCreator("Yu");
//        teachingBasicDataBll.addEduSystem(eduSystem);
//    }

    @Test
    public void testModifyEduSystem() throws Exception {

    }
}