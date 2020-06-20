package club.codedrinker.eduservice.mapper;

import club.codedrinker.eduservice.entity.EduCourse;
import club.codedrinker.eduservice.entity.frontvo.CourseWebVo;
import club.codedrinker.eduservice.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-06-14
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    CoursePublishVo getPublishCourseInfo(String courseId);

    CourseWebVo getBaseCourseInfo(String courseId);
}
