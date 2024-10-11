package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
    public static void main( String[] args ) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // 엔티티 매니저는 데이터변경시 트랜잭션을 시작해야 한다.
        tx.begin();
        // 영속성 엔티티 조회
        Member memberA = em.find(Member.class, "memberA");

        // 영속성 엔티티 데이터 수정
        memberA.setUnsername("hi");
        memberA.setAge(10);

        // 이런 코드가 있어야 하지 않을까?
        // em.update(memberA)
        tx.commit(); // 트랜잭션 커밋
    }
}

