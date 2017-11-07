package com.planrest.dao.impl;

import com.planrest.dao.interfaces.FriendDAO;
import com.planrest.entities.Friend;
import com.planrest.entities.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
@Repository
public class FriendDAOImpl extends CrudDAOImpl<Friend, Integer> implements Serializable, FriendDAO {

    private static final long serialVersionUID = 1L;


}
