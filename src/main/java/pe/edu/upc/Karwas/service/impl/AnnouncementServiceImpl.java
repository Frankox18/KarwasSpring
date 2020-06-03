package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.Announcement;
import pe.edu.upc.Karwas.model.repository.AnnouncementRepository;
import pe.edu.upc.Karwas.service.AnnouncementService;
@Service
public class AnnouncementServiceImpl implements AnnouncementService{

	@Autowired
	private AnnouncementRepository announcementRepository;
	@Override
	@Transactional
	public Announcement create(Announcement entity) throws Exception {
		// TODO Auto-generated method stub
		return announcementRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Announcement> readAll() throws Exception {
		// TODO Auto-generated method stub
		return announcementRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Announcement> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return announcementRepository.findById(id);
	}

	@Override
	@Transactional
	public Announcement update(Announcement entity) throws Exception {
		// TODO Auto-generated method stub
		return announcementRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		announcementRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		// TODO Auto-generated method stub
		announcementRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Announcement> findByServicePrice(Integer servicePrice) throws Exception {
		// TODO Auto-generated method stub
		return announcementRepository.findByServicePrice(servicePrice);
	}

}
