CREATE DEFINER=`root`@`localhost` PROCEDURE `devicespancleantest`()
BEGIN
DECLARE count INT Default 0;
DECLARE count2 INT Default 0;
	simple_loop: LOOP
		SET @a := count + 1;
		SET @b := (select person_oid from randomperson as r where r.person_id = @a);
		/*loop1*/
        SET @statement = CONCAT('create table devicespanclean2_',@b,'tt_1 as select * from devicespanclean2_10b_01e;');
		PREPARE stmt FROM @statement;
			EXECUTE stmt;
		    DEALLOCATE PREPARE stmt;
		SET @statement2 = CONCAT('truncate table devicespanclean2_',@b,'tt_1;');
		PREPARE stmt2 FROM @statement2;
			EXECUTE stmt2;
		    DEALLOCATE PREPARE stmt2;
		SET @statement3 = CONCAT('insert into devicespanclean2_',@b,'tt_1 select * from devicespanclean2_',@b,'b_01e;');
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
				SET @statement4 = CONCAT('update devicespanclean2_',@d,'b_01e set class = \'no\';');
					PREPARE stmt4 FROM @statement4;
					EXECUTE stmt4;
					DEALLOCATE PREPARE stmt4;
				SET @statement5 = CONCAT('insert into devicespanclean2_',@b,'tt_1 select * from devicespanclean2_',@d,'b_01e;');
					PREPARE stmt5 FROM @statement5;
					EXECUTE stmt5;
					DEALLOCATE PREPARE stmt5;
				SET @statement6 = CONCAT('update devicespanclean2_',@d,'b_01e set class = \'yes\';');
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