package Study.demo.dto;

import Study.demo.entity.demo;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //생성자 어노테이션
@ToString
public class demoForm {
    //폼에서 받은 데이터를 임시로 받아서 DB에 저장하는 역할
    //데이터의 안전한 보관을 위해 사용한다고 함

    private String title;
    private String content;

    public demo toEntity() { return new demo(null,title,content);}
}
