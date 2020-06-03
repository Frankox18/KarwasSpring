package pe.edu.upc.karwasspr.service;

import java.util.List;

import pe.edu.upc.karwasspr.model.entity.Announcement;

public interface AnnouncementService extends CrudService<Announcement, Integer>{

	List<Announcement> findByServicePrice( Integer servicePrice ) throws Exception;
}
