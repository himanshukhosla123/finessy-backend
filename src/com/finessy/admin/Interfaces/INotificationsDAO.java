package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.NotificationsDTO;

public interface INotificationsDAO {
	
	ArrayList<NotificationsDTO> readAll() throws ClassNotFoundException ,SQLException;
	NotificationsDTO add(NotificationsDTO notificationDTO) throws ClassNotFoundException, SQLException;
	NotificationsDTO read(NotificationsDTO notificationDTO) throws ClassNotFoundException, SQLException;
	NotificationsDTO update(NotificationsDTO notificationDTO) throws ClassNotFoundException, SQLException;
	NotificationsDTO delete(NotificationsDTO notificationDTO) throws ClassNotFoundException, SQLException;

}
