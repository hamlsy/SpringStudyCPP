package Study.demo.controller;

import Study.demo.dto.demoForm;
import Study.demo.entity.demo;
import Study.demo.repositiry.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //2. 컨트롤러 선언 (만들어둔 html 주소를 연결할 것임)
public class demoController {
    @GetMapping("/templates/create") //이 상태에서 서버를 돌리고 localhost:8080/create를 하면 createDemo.html을 반환해 보여준다.
    public String newDemoForm(){
        return "createDemo";
    } //이렇게 url요청을 접수해 사용자에게 입력을 받을 페이지를 보여준다.

    @PostMapping("/templates/create")
    public String createDemo(demoForm form){ //폼 데이터를 dto로 받음
        //얘를 데이터베이스에 저장할 것임 dto를 엔티티로 전환할것임
        demo demo=form.toEntity(); //dto에 toEntity()메소드를 만들어 dto인 폼 객체를 엔티티 객체로 변환시킴
        demo saved=demoRepository.save(demo);//아래 리파지터리가 생성되었으므로, save메서드에 저장된 엔티티를 saved객체에 반환(레파지터리 생성이 되어야함)db에 저장
        return "";
    }
    //리파지터리로 엔티티를 db에 저장
    @Autowired //의존성 주입
    private DemoRepository demoRepository; //리파지터리 생성

    //단일 데이터 받기
    @PostMapping("/listDemo/{id}") //받고자 하는 url넣기.
    public String createDemoList(){
        //demo saved=demoRepository.save(demo);
        return "";
    }

}
