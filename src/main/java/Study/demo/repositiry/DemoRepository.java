package Study.demo.repositiry;

import Study.demo.entity.demo;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DemoRepository extends CrudRepository<demo,Long> {
    //JPA에서 제공하는 인터페이스를 상속해 엔티티 관리
    @Override
    ArrayList<demo> findAll();
}
