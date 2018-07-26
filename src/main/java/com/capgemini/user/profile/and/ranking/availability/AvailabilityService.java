package com.capgemini.user.profile.and.ranking.availability;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.user.profile.and.ranking.enums.DayOfTheWeek;
import com.capgemini.user.profile.and.ranking.enums.Hours;

public class AvailabilityService {

	private AvailabilityMapper availabilityMapper;
	private AvailabilityDAO availabilityDAO;
	private AvailabilityDTO availabilityDTO;
	private String comment;
	private AvailabilityEntity editedEntity;
	private AvailabilityEntity entityToRemove;

	@Autowired
	public AvailabilityService(AvailabilityDAO availabilityDAO, AvailabilityMapper availabilityMapper) {
		this.availabilityDAO = availabilityDAO;
		this.availabilityMapper = availabilityMapper;
	}

	public void addAvailability(AvailabilityDTO availabilityDTO) {
		AvailabilityEntity userAvailability = availabilityMapper.from(availabilityDTO);
		availabilityDAO.add(userAvailability);
	}

	public void editAvailability(long id, DayOfTheWeek day, Hours hour) {

		List<AvailabilityEntity> userAvailability = availabilityDAO.showAvailability(id);

		for (AvailabilityEntity userEntity : userAvailability) {
			if (userEntity.getDayOfTheWeek() == day) {
				if (userEntity.getHours() == hour) {
					editedEntity = availabilityMapper.edit(userEntity, availabilityDTO);
				}
			}
		}
		availabilityDAO.add(editedEntity);
	}

	public void suspendAndCommentAvailability(long userID, DayOfTheWeek day, Hours hour) {

		availabilityDTO.setSuspended(true);
	}

	public void removeAvailability(long userID, DayOfTheWeek day, Hours hour) {

		List<AvailabilityEntity> userAvailability = availabilityDAO.showAvailability(userID);
		
		for (AvailabilityEntity userEntity : userAvailability) {
			if (userEntity.getDayOfTheWeek() == day) {
				if (userEntity.getHours() == hour) {
					entityToRemove = availabilityMapper.edit(userEntity, availabilityDTO);
				}
			}
		}
		availabilityDAO.remove(entityToRemove);
	}

	public void showSimilarAvailabilityUsers(long id) {
		
		
	}

}
