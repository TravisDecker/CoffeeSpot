//package com.straylense.geosamplelog.domain;
//
//import com.straylense.geosamplelog.domain.UserRole;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.UUID;
//
//@Repository
//public interface UserRoleRepository extends CrudRepository<UserRole, UUID> {
//
//    @Query("select a.role from UserRole a, User b where b.username=?1 and a.userId=b.userId")
//    public List<String> findRoleByUsername(String username);
//}
