/*
 * Generated by JasperReports - 3/14/11 4:16 PM
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.net.*;

import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;


/**
 *
 */
public class AF56Item_1300090597201_771028 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_REPORT_FILE_RESOLVER = null;
    private JRFillParameter parameter_ITEMCOUNT = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillField field_sefinterestgross = null;
    private JRFillField field_payperiod = null;
    private JRFillField field_sefgross = null;
    private JRFillField field_sefDP = null;
    private JRFillField field_basicDP = null;
    private JRFillField field_ledger46cadastralLotNo = null;
    private JRFillField field_basicTotal = null;
    private JRFillField field_ledger46type46code = null;
    private JRFillField field_ledger46location = null;
    private JRFillField field_amount = null;
    private JRFillField field_basicinterestgross = null;
    private JRFillField field_ledger46taxpayerName = null;
    private JRFillField field_basicgross = null;
    private JRFillField field_ledger46assessedValue = null;
    private JRFillField field_ledger46pin = null;
    private JRFillField field_ledger46tdno = null;
    private JRFillField field_advancePayment = null;
    private JRFillField field_ledger46classCode = null;
    private JRFillField field_sefTotal = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;


    /**
     *
     */
    public void customizedInit(
        Map pm,
        Map fm,
        Map vm
        )
    {
        initParams(pm);
        initFields(fm);
        initVars(vm);
    }


    /**
     *
     */
    private void initParams(Map pm)
    {
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_FORMAT_FACTORY");
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_REPORT_FILE_RESOLVER = (JRFillParameter)pm.get("REPORT_FILE_RESOLVER");
        parameter_ITEMCOUNT = (JRFillParameter)pm.get("ITEMCOUNT");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
    }


    /**
     *
     */
    private void initFields(Map fm)
    {
        field_sefinterestgross = (JRFillField)fm.get("sefinterestgross");
        field_payperiod = (JRFillField)fm.get("payperiod");
        field_sefgross = (JRFillField)fm.get("sefgross");
        field_sefDP = (JRFillField)fm.get("sefDP");
        field_basicDP = (JRFillField)fm.get("basicDP");
        field_ledger46cadastralLotNo = (JRFillField)fm.get("ledger.cadastralLotNo");
        field_basicTotal = (JRFillField)fm.get("basicTotal");
        field_ledger46type46code = (JRFillField)fm.get("ledger.type.code");
        field_ledger46location = (JRFillField)fm.get("ledger.location");
        field_amount = (JRFillField)fm.get("amount");
        field_basicinterestgross = (JRFillField)fm.get("basicinterestgross");
        field_ledger46taxpayerName = (JRFillField)fm.get("ledger.taxpayerName");
        field_basicgross = (JRFillField)fm.get("basicgross");
        field_ledger46assessedValue = (JRFillField)fm.get("ledger.assessedValue");
        field_ledger46pin = (JRFillField)fm.get("ledger.pin");
        field_ledger46tdno = (JRFillField)fm.get("ledger.tdno");
        field_advancePayment = (JRFillField)fm.get("advancePayment");
        field_ledger46classCode = (JRFillField)fm.get("ledger.classCode");
        field_sefTotal = (JRFillField)fm.get("sefTotal");
    }


    /**
     *
     */
    private void initVars(Map vm)
    {
        variable_PAGE_NUMBER = (JRFillVariable)vm.get("PAGE_NUMBER");
        variable_COLUMN_NUMBER = (JRFillVariable)vm.get("COLUMN_NUMBER");
        variable_REPORT_COUNT = (JRFillVariable)vm.get("REPORT_COUNT");
        variable_PAGE_COUNT = (JRFillVariable)vm.get("PAGE_COUNT");
        variable_COLUMN_COUNT = (JRFillVariable)vm.get("COLUMN_COUNT");
    }


    /**
     *
     */
    public Object evaluate(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(5));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Boolean)(new Boolean(((java.lang.Integer)parameter_ITEMCOUNT.getValue()).intValue() <= 5));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46type46code.getValue()) + " " + ((java.lang.String)field_ledger46classCode.getValue()));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46location.getValue()));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_ledger46assessedValue.getValue()));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_amount.getValue()));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((java.lang.String)field_payperiod.getValue()));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46tdno.getValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_sefDP.getValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_sefTotal.getValue()));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_basicDP.getValue()));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_basicTotal.getValue()));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46location.getValue()));//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.lang.Boolean)(new Boolean(((java.math.BigDecimal)field_advancePayment.getValue()).compareTo(BigDecimal.ZERO) > 0));//$JR_EXPR_ID=21$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateOld(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(5));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Boolean)(new Boolean(((java.lang.Integer)parameter_ITEMCOUNT.getValue()).intValue() <= 5));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46type46code.getOldValue()) + " " + ((java.lang.String)field_ledger46classCode.getOldValue()));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46location.getOldValue()));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_ledger46assessedValue.getOldValue()));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_amount.getOldValue()));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((java.lang.String)field_payperiod.getOldValue()));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46tdno.getOldValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_sefDP.getOldValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_sefTotal.getOldValue()));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_basicDP.getOldValue()));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_basicTotal.getOldValue()));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46location.getOldValue()));//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.lang.Boolean)(new Boolean(((java.math.BigDecimal)field_advancePayment.getOldValue()).compareTo(BigDecimal.ZERO) > 0));//$JR_EXPR_ID=21$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateEstimated(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(5));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Boolean)(new Boolean(((java.lang.Integer)parameter_ITEMCOUNT.getValue()).intValue() <= 5));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46type46code.getValue()) + " " + ((java.lang.String)field_ledger46classCode.getValue()));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46location.getValue()));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_ledger46assessedValue.getValue()));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_amount.getValue()));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((java.lang.String)field_payperiod.getValue()));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46tdno.getValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_sefDP.getValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_sefTotal.getValue()));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_basicDP.getValue()));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_basicTotal.getValue()));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)(((java.lang.String)field_ledger46location.getValue()));//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.lang.Boolean)(new Boolean(((java.math.BigDecimal)field_advancePayment.getValue()).compareTo(BigDecimal.ZERO) > 0));//$JR_EXPR_ID=21$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
