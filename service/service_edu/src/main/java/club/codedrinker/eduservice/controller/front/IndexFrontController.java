package club.codedrinker.eduservice.controller.front;

import club.codedrinker.commomutils.R;
import club.codedrinker.eduservice.entity.EduCourse;
import club.codedrinker.eduservice.entity.EduTeacher;
import club.codedrinker.eduservice.service.EduCourseService;
import club.codedrinker.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/eduservice/indexfront")
public class IndexFrontController {
    @Autowired
    private EduCourseService eduCourseService;
    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("index")
    public R index(){

        QueryWrapper<EduCourse> eduCourseQueryWrapper = new QueryWrapper<>();
        eduCourseQueryWrapper.orderByDesc("id");
        eduCourseQueryWrapper.last("limit 8");
        List<EduCourse> courseList = eduCourseService.list(eduCourseQueryWrapper);

        QueryWrapper<EduTeacher> eduTeacherQueryWrapper = new QueryWrapper<>();
        eduTeacherQueryWrapper.orderByDesc("id");
        eduTeacherQueryWrapper.last("limit 4");
        List<EduTeacher> teacherList = eduTeacherService.list(eduTeacherQueryWrapper);

        return R.ok().data("courseList",courseList).data("teacherList",teacherList);
    }
}
