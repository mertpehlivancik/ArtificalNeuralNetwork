CREATE DEFINER=`root`@`localhost` PROCEDURE `cellspancleanaddclass`()
BEGIN
DECLARE count INT Default 0;
DECLARE count2 INT Default 0;
  simple_loop: LOOP
  SET @a := count + 1;
  SET @b := (select person_oid from randomperson as r where r.person_id = @a);
  
  simple_loop2: LOOP
  SET @c := count2 + 1;
  
  SET @statement = CONCAT('alter table cellspanclean2_',@b,'a_',@c,'c add column class varchar(5) default \'yes\'');  
    PREPARE stmt FROM @statement;
                 EXECUTE stmt;
                 DEALLOCATE PREPARE stmt; 
	SET @statement2 = CONCAT('alter table cellspanclean2_',@b,'a_',@c,'d add column class varchar(5) default \'no\'');  
    PREPARE stmt2 FROM @statement2;
                 EXECUTE stmt2;
                 DEALLOCATE PREPARE stmt2; 
  
              SET count2 = count2 +1;
		  IF count2=10 THEN
              SET count2 := count2 - 10;
              SET @c := count2 + 0;
              LEAVE simple_loop2;
		  END IF;
      END LOOP simple_loop2;  
      
              SET count = count + 1;
          IF count=20 THEN
              LEAVE simple_loop;
           END IF; 
	END LOOP simple_loop;  
END