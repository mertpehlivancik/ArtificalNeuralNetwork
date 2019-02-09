CREATE DEFINER=`root`@`localhost` PROCEDURE `devicespancleanproc7525e`()
BEGIN
DECLARE count INT Default 0;
  simple_loop: LOOP
  SET @a := count + 1;
  SET @b := (select person_oid from randomperson as r where r.person_id = @a);
	
  SET @statement = CONCAT('create table devicespanclean2_',@b,'b_01e ( select * from devicespanclean2_',@b,'b ORDER BY RAND() LIMIT 100 );');
    PREPARE stmt FROM @statement;
                 EXECUTE stmt;
                 DEALLOCATE PREPARE stmt; 
                
              SET count = count + 1;
          IF count=20 THEN
              LEAVE simple_loop;
           END IF; 
	END LOOP simple_loop; 
END