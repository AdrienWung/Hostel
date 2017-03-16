package nju.adrien.repository;

import nju.adrien.model.HotelPlan;
import nju.adrien.model.VipInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

/**
 * Created by JiachenWang on 2017/3/9.
 */
public interface HotelPlanRepository extends JpaRepository<HotelPlan, String> {
    @Query("select a from HotelPlan a where a.hid = ?1")
    List<HotelPlan> findByHid(String hid);

    @Query("select a.planid from HotelPlan a where planid=(select max(planid) from HotelPlan)")
    String getMaxPlanid();

    @Query("select a from HotelPlan a where a.hid = ?1 and a.date = ?2 and a.type = ?3")
    HotelPlan findRepeat(String hid, Date date, String type);

    @Query("select a from HotelPlan a where a.hid = ?1 and a.date = ?2")
    List<HotelPlan>  findByHidDate(String hid, Date date);
}