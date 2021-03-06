/*******************************************************************************
 * * Copyright 2012 Impetus Infotech.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 ******************************************************************************/
package com.impetus.kundera.persistence.jta;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.impetus.kundera.KunderaException;

/**
 * Kundera implementation for JTA {@link UserTransaction}. 
 * This needs to hooked up with initial context for use of Kundera's commit/rollback handling.
 * @author vivek.mishra
 * 
 */
public class KunderaJTAUserTransaction implements UserTransaction
{
    private boolean isTransactionInProgress;

    /** The Constant log. */
    private static final Log log = LogFactory.getLog(KunderaJTAUserTransaction.class);

    /*
     * (non-Javadoc)
     * 
     * @see javax.transaction.UserTransaction#begin()
     */
    @Override
    public void begin() throws NotSupportedException, SystemException
    {
        isTransactionInProgress = true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.transaction.UserTransaction#commit()
     */
    @Override
    public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException,
            SecurityException, IllegalStateException, SystemException
    {
        if (isTransactionInProgress)
        {
            // Do commit!
        }
        else
        {

            throw new KunderaException("No transaction in progress.");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.transaction.UserTransaction#getStatus()
     */
    @Override
    public int getStatus() throws SystemException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.transaction.UserTransaction#rollback()
     */
    @Override
    public void rollback() throws IllegalStateException, SecurityException, SystemException
    {
        if (isTransactionInProgress)
        {
            // Do commit!
        }
        else
        {

            throw new KunderaException("No transaction in progress.");
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.transaction.UserTransaction#setRollbackOnly()
     */
    @Override
    public void setRollbackOnly() throws IllegalStateException, SystemException
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.transaction.UserTransaction#setTransactionTimeout(int)
     */
    @Override
    public void setTransactionTimeout(int arg0) throws SystemException
    {
        // TODO Auto-generated method stub

    }

}
