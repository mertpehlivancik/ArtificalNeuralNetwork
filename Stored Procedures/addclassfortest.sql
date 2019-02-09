CREATE DEFINER=`root`@`localhost` PROCEDURE `addclassfortest`()
BEGIN
DECLARE count INT Default 0;
  simple_loop: LOOP
  SET @a := count + 1;
  SET @b := (select person_oid from randomperson as r where r.person_id = @a);
	
  SET @statement = CONCAT('alter table activityspanclean2_',@b,'b_01e add column class varchar(5) default \'yes\'');  
    PREPARE stmt FROM @statement;
                 EXECUTE stmt;
                 DEALLOCATE PREPARE stmt; 
	SET @statement2 = CONCAT('alter table callspanclean3_',@b,'b_01e add column class varchar(5) default \'yes\'');  
    PREPARE stmt2 FROM @statement2;
                 EXECUTE stmt2;
                 DEALLOCATE PREPARE stmt2; 
	SET @statement3 = CONCAT('alter table cellspanclean2_',@b,'b_01e add column class varchar(5) default \'yes\'');  
    PREPARE stmt3 FROM @statement3;
                 EXECUTE stmt3;
                 DEALLOCATE PREPARE stmt3; 
	SET @statement4 = CONCAT('alter table devicespanclean2_',@b,'b_01e add column class varchar(5) default \'yes\'');  
    PREPARE stmt4 FROM @statement4;
                 EXECUTE stmt4;
                 DEALLOCATE PREPARE stmt4;
                
              SET count = count + 1;
          IF count=20 THEN
              LEAVE simple_loop;
           END IF; 
	END LOOP simple_loop; 
END