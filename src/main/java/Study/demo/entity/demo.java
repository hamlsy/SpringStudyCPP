package Study.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity //1.Entity(jpa 제공 어노테이션)를 선언해 db에 테이블 생성
@Getter
public class demo {
    @Id //id선언으로 기본키 지정
    @GeneratedValue(strategy=GenerationType.IDENTITY) //따로 설정하지 않아도 새로운 컬럼이 들어올 때 자동으로 카운팅해줌
    private Long id;
    @Column //컬럼을 생성해 title과 content생성
    private String title;
    @Column
    private String content;
}
//테이블 생성 완료. 이제 보여지는 html을 만들것임(부트스트랩에서 긁어옴)