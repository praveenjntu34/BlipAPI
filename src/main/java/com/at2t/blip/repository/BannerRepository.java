package com.at2t.blip.repository;

import com.at2t.blip.dao.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.at2t.blip.dao.Banner;
import com.at2t.blip.dto.BannerDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BannerRepository extends CrudRepository<Banner, Integer> {

	@Modifying
	@Query(value = "INSERT INTO Banner(RelTenantInstitutionId,BannerName,BannerStreamId) VALUES(:relTenantInstitutionId,:bannerName,:bannerStreamId)", nativeQuery = true)
	public void addBanner(@Param("relTenantInstitutionId") int relTenantInstitutionId,
			@Param("bannerName") String bannerName, @Param("bannerStreamId") String bannerStreamId);

	@Modifying
	@Query(value = "Delete from Banner where BannerId=:bannerId", nativeQuery = true)
	public void deleteBanner(@Param("bannerId") int bannerId);

	@Query("SELECT b FROM Banner b WHERE relTenantInstitutionId= :relTenantInstitutionId")
	List<Banner> getBanners(int relTenantInstitutionId);

	@Modifying
	@Transactional
	@Query(value = "update Banner set RelTenantInstitutionId=:relTenantInstitutionId , Title =:title, ShortDescription =:shortDescription where BannerId=:bannerId")
	public void updateBanner(@Param("relTenantInstitutionId") int relTenantInstitutionId,
			@Param("title") String title,@Param("shortDescription") String shortDescription, @Param("bannerId") int bannerId);
}
