CREATE DEFINER=`root`@`localhost` PROCEDURE `callspancleantest`()
BEGIN
DECLARE count INT Default 0;
DECLARE count2 INT Default 0;
	simple_loop: LOOP
		SET @a := count + 1;
		SET @b := (select person_oid from randomperson as r where r.person_id = @a);
		/*loop1*/
        SET @statement = CONCAT('create table callspanclean3_',@b,'tt_1 as select * from callspanclean3_10b_01e;');
		PREPARE stmt FROM @statement;
			EXECUTE stmt;
		    DEALLOCATE PREPARE stmt;
		SET @statement2 = CONCAT('truncate table callspanclean3_',@b,'tt_1;');
		PREPARE stmt2 FROM @statement2;
			EXECUTE stmt2;
		    DEALLOCATE PREPARE stmt2;
		SET @statement3 = CONCAT('insert into callspanclean3_',@b,'tt_1 select * from callspanclean3_',@b,'b_01e;');
		PREPARE stmt3 FROM @statement3;
			EXECUTE stmt3;
		    DEALLOCATE PREPARE stmt3;
		/*loop1*/
		simple_loop2: LOOP
			SET @c := count2 + 1;
			/*loop2*/
			SET @d := (select person_oid from randomperson as r where r.person_id = @c);
			IF @b <> @d
            THEN
				SET @statement4 = CONCAT('update callspanclean3_',@d,'b_01e set class = \'no\';');
					PREPARE stmt4 FROM @statement4;
					EXECUTE stmt4;
					DEALLOCATE PREPARE stmt4;
				SET @statement5 = CONCAT('insert into callspanclean3_',@b,'tt_1 select * from callspanclean3_',@d,'b_01e;');
					PREPARE stmt5 FROM @statement5;
					EXECUTE stmt5;
					DEALLOCATE PREPARE stmt5;
				SET @statement6 = CONCAT('update callspanclean3_',@d,'b_01e set class = \'yes\';');
					PREPARE stmt6 FROM @statement6;
					EXECUTE stmt6;
					DEALLOCATE PREPARE stmt6;
			END IF;
			/*loop2*/
			SET count2 = count2 +1;
				IF count2=20 THEN
					SET count2 := count2 - 20;
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