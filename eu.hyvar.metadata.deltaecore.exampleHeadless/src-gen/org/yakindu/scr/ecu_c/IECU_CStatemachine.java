package org.yakindu.scr.ecu_c;
import org.yakindu.scr.IStatemachine;

public interface IECU_CStatemachine extends IStatemachine {
	public interface SCInterface {

	}

	public SCInterface getSCInterface();

	public interface SCIData {
		public String getFeaturesA();
		public void setFeaturesA(String value);
		public String getFeaturesU();
		public void setFeaturesU(String value);
		public String getFeaturesE();
		public void setFeaturesE(String value);
		public String getFeaturesG();
		public void setFeaturesG(String value);
		public String getFeaturesS();
		public void setFeaturesS(String value);
		public String getFeaturesN();
		public void setFeaturesN(String value);

		public void setSCIDataOperationCallback(SCIDataOperationCallback operationCallback);
	}

	public interface SCIDataOperationCallback {
		public void initFiat();
		public String operA();
		public String operU();
		public String operE();
		public String operG();
		public String operS();
		public String operN();
	}

	public SCIData getSCIData();

}
