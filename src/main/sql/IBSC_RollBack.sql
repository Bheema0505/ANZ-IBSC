SET @EXPECTED_RECORDS_EXISTING = 1
	   SET @EXPECTED_RECORDS_DELETED = 1

		 SELECT @ROWCOUNT = count(*) FROM IBSC_USER(NOLOCK)  

	     IF @ROWCOUNT  = @EXPECTED_RECORDS_EXISTING

	     BEGIN
		 BEGIN TRAN

			DELETE FROM IBSC_USER WHERE 
	    Emp_Id in (1191716,1191655,1172875,1172888,1172828) 

			IF @@ROWCOUNT = @EXPECTED_RECORDS_DELETED
			BEGIN
				COMMIT TRAN
					PRINT 'Commit executed - DELETE in IBSC_USER for user-details  ::: SUCCESS MESSAGE'
	            END
	        ELSE
	        BEGIN
	            ROLLBACK TRAN
	                PRINT 'ROLLBACK executed - DELETE in IBSC_USER for user-details   ::: FAILURE MESSAGE'
	            END
			END
		ELSE
			BEGIN
				PRINT 'Transaction not submitted - zero OR incorrect number of target records found in DELETE in IBSC_USER for user-details ::: ERROR MESSAGE'
		END