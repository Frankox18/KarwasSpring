package pe.edu.upc.Karwas.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Karwas.model.entity.Announcement;
@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer>{

	List<Announcement> findByServicePrice( Integer servicePrice ) throws Exception;
}
