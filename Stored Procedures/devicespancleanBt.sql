CREATE DEFINER=`root`@`localhost` PROCEDURE `devicespancleanBt`()
BEGIN
DECLARE count INT Default 0;
DECLARE count2 INT Default 0;
	simple_loop: LOOP
		SET @a := count + 1;
		SET @b := (select person_oid from randomperson as r where r.person_id = @a);
		/*loop1*/
        SET @statement = CONCAT('Create table devicespanclean2_',@b,'tt_b_1 as select x.device_oid,x.dd,x.wdu,x.stime,x.duration,x.class from devicespanclean2_',@b,'tt_all_1 as x;');
			PREPARE stmt FROM @statement;
                 EXECUTE stmt;
                 DEALLOCATE PREPARE stmt;
		/*loop1*/
		SET count = count + 1;
			IF count=20 THEN
              LEAVE simple_loop;
			END IF; 
	END LOOP simple_loop;
END