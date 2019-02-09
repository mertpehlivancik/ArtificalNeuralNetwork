CREATE DEFINER=`root`@`localhost` PROCEDURE `cellspancleanproc7525cd`()
BEGIN
DECLARE count INT Default 0;
DECLARE count2 INT Default 0;
  simple_loop: LOOP
  SET @a := count + 1;
  SET @b := (select person_oid from randomperson as r where r.person_id = @a);
  
  
  simple_loop2: LOOP
  SET @c := count2 + 1;
  
  
  SET @statement = CONCAT('create temporary table tmptbl ( select * from cellspanclean2_',@b,'a ORDER BY RAND() LIMIT 7200 );');
    PREPARE stmt FROM @statement;
                 EXECUTE stmt;
                 DEALLOCATE PREPARE stmt;
  SET @statement2 = CONCAT('select * from tmptbl order by starttime');
    PREPARE stmt2 FROM @statement2;
                 EXECUTE stmt2;
                 DEALLOCATE PREPARE stmt2;               
  SET @statement3 = CONCAT('create table cellspanclean2_',@b,'a_',@c,'c ( select * from tmptbl order by starttime LIMIT 6840 );');
    PREPARE stmt3 FROM @statement3;
                 EXECUTE stmt3;
                 DEALLOCATE PREPARE stmt3; 
  SET @statement4 = CONCAT('create table cellspanclean2_',@b,'a_',@c,'d ( select * from tmptbl order by starttime DESC LIMIT 360 );');
    PREPARE stmt4 FROM @statement4;
                 EXECUTE stmt4;
                 DEALLOCATE PREPARE stmt4; 
              drop table tmptbl;
              
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