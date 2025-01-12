package com.padwan.test.repository;

import com.padwan.test.entity.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

    @Query(value = "SELECT j1.nome AS mestre, j2.nome AS aprendiz FROM jedi j1 LEFT JOIN jedi j2 ON j1.id = j2.mentor_id WHERE j1.status = 'mestre jedi'", nativeQuery = true)
    List<Object[]> findAllMestresEAprendizes();

    @Query(value = "SELECT * FROM jedi WHERE midichlorians > 9000", nativeQuery = true)
    List<Jedi> findAllJedisWithHighMidichlorians();

    @Query(value = "SELECT status, COUNT(*) AS quantidade FROM jedi GROUP BY status", nativeQuery = true)
    List<Object[]> countJedisByStatus();

    // query para buscar Jedis com base no mentor_id
    @Query("SELECT j FROM Jedi j WHERE j.mentor.id = :mentorId")
    List<Jedi> findAllByMentorId(@Param("mentorId") Long mentorId);
}
