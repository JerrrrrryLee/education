package club.codedrinker.servicebase.exceptionhandler;


import club.codedrinker.commomutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("全局异常处理！");
    }


    @ExceptionHandler(EducationException.class)
    @ResponseBody
    public R error(EducationException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
