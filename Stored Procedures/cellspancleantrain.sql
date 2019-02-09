CREATE DEFINER=`root`@`localhost` PROCEDURE `cellspancleantrain`()
BEGIN
DECLARE count INT Default 0;
DECLARE count2 INT Default 0;
DECLARE count3 INT Default 0;

  simple_loop: LOOP
  SET @a := count + 1;
  SET @b := (select person_oid from randomperson as r where r.person_id = @a);
	/*loop1*/
    
	/*loop1*/
	simple_loop2: LOOP
	SET @c := count2 + 1;
    /*loop2*/
		SET @statement = CONCAT('create table cellspanclean2_',@b,'t_',@c,' as select * from cellspanclean2_10b_01e;');
		PREPARE stmt FROM @statement;
			EXECUTE stmt;
		    DEALLOCATE PREPARE stmt;
		SET @statement2 = CONCAT('truncate table cellspanclean2_',@b,'t_',@c,';');
		PREPARE stmt2 FROM @statement2;
			EXECUTE stmt2;
		    DEALLOCATE PREPARE stmt2;
		SET @statement3 = CONCAT('insert into cellspanclean2_',@b,'t_',@c,' select * from cellspanclean2_',@b,'a_',@c,'c;');
		PREPARE stmt3 FROM @statement3;
			EXECUTE stmt3;
		    DEALLOCATE PREPARE stmt3;
	/*loop2*/
			simple_loop3: LOOP
			SET @e := count3 + 1;
			SET @d := (select person_oid from randomperson as r where r.person_id = @e);
            /*loop3*/
            IF @b <> @d
            THEN
				SET @statement4 = CONCAT('insert into cellspanclean2_',@b,'t_',@c,' select * from cellspanclean2_',@d,'a_',@c,'d;');
					PREPARE stmt4 FROM @statement4;
					EXECUTE stmt4;
					DEALLOCATE PREPARE stmt4;
			END IF;
			/*loop3*/
			SET count3 = count3 +1;
				IF count3=20 THEN
					SET count3 := count3 - 20;
					SET @c := count3 + 0;
					LEAVE simple_loop3;
				END IF;
			END LOOP simple_loop3;
  
 
              
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