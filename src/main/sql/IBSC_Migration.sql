USE IB_TRANS_F11_FEBA1
GO

IF @@ERROR = 0
BEGIN
	DECLARE @ROWCOUNT INT
	DECLARE @EXPECTED_RECORDS_EXISTING INT
	DECLARE @EXPECTED_RECORDS_INSERTED INT
	DECLARE @EXPECTED_RECORDS_UPDATED INT
	DECLARE @EXPECTED_RECORDS_DELETED INT
	DECLARE @ROWCOUNT_UPDATED INT

	/****************************************** IBSC_USER Migration Scripts *********************************************/
      
	 SET @EXPECTED_RECORDS_EXISTING = 0
	   SET @EXPECTED_RECORDS_INSERTED = 1
	    SELECT @ROWCOUNT = count(*) FROM IBSC_USER(NOLOCK) 
		   IF @ROWCOUNT  = @EXPECTED_RECORDS_EXISTING

     BEGIN
	 BEGIN TRAN
	    INSERT INTO IBSC_USER (Emp_Id,Pswd,FirstName,LastName,Email_Id,CQ,Ans,Ob_Status,Pending_Trainings,Total_Trainings)
			

		IF @@ROWCOUNT = @EXPECTED_RECORDS_INSERTED
		BEGIN
			COMMIT TRAN
				PRINT 'Commit executed - Insert in IBSC_USER for user-details  ::: SUCCESS MESSAGE'
            END
        ELSE
        BEGIN
            ROLLBACK TRAN
                PRINT 'ROLLBACK executed - ERROR in IBSC_USER for user-details  ::: FAILURE MESSAGE'
            END
		END
	ELSE
		BEGIN
			PRINT 'Transaction not submitted - zero OR incorrect number of target records found in Insert in IBSC_USER for user-details  ::: ERROR MESSAGE'
	END