CREATE DEFINER=`root`@`localhost` PROCEDURE `activityspancleanproc7525`()
BEGIN
DECLARE count INT Default 0;
  simple_loop: LOOP
    CREATE temporary table tmptbl(countofrow float8);
	SET @a := count + 1;
    SET @b := (select person_oid from randomperson as r where r.person_id = @a);
    SET @statement = CONCAT('insert into tmptbl(countofrow) select COUNT(*) from activityspanclean2_',@b,'');
    PREPARE stmt FROM @statement;
                 EXECUTE stmt;
                 DEALLOCATE PREPARE stmt;
    SET @percentageof75 := (select ((countofrow*75)/100) from tmptbl);
    /*SELECT @percentageof75;*/
    SET @percentageof25 := (select ((countofrow*25)/100) from tmptbl);
    /*SELECT @percentageof25;*/
    SET @per75aftrcomma := (SELECT SUBSTRING_INDEX(@percentageof75, ".", -1));
    /*SELECT @per75aftrcomma;*/
    SET @per25aftrcomma := (SELECT SUBSTRING_INDEX(@percentageof25, ".", -1));
    /*SELECT @per25aftrcomma;*/

    IF @per75aftrcomma = @per25aftrcomma
    THEN  set @percentageof75 := @percentageof75- 0.5; 
          set @percentageof25 := @percentageof25+ 0.5;
    ELSE 
    set @percentageof75 := (SELECT ROUND(@percentageof75,0)); 
    set @percentageof25 := (SELECT ROUND(@percentageof25,0));
    END IF;
    
    SET @statement2 = CONCAT('Create table activityspanclean2_',@b,'a ( SELECT * FROM activityspanclean2_',@b,' ORDER BY starttime LIMIT ',@percentageof75,');');             
         PREPARE stmt2 FROM @statement2;
                 EXECUTE stmt2;
                 DEALLOCATE PREPARE stmt2;
     SET @statement3 = CONCAT('Create table activityspanclean2_',@b,'b ( SELECT * FROM activityspanclean2_',@b,' ORDER BY starttime DESC LIMIT ',@percentageof25,');');             
         PREPARE stmt3 FROM @statement3;
                 EXECUTE stmt3;
                 DEALLOCATE PREPARE stmt3; 
                 SET count = count + 1;
                 drop table tmptbl;
           IF count=20 THEN
              LEAVE simple_loop;
           END IF; 
	END LOOP simple_loop;    
END