package org.yakindu.scr.ecu_c;

public class ECU_CStatemachine implements IECU_CStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

	}

	protected SCInterfaceImpl sCInterface;

	protected class SCIDataImpl implements SCIData {

		private SCIDataOperationCallback operationCallback;

		public void setSCIDataOperationCallback(SCIDataOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

		private String featuresA;

		public String getFeaturesA() {
			return featuresA;
		}

		public void setFeaturesA(String value) {
			this.featuresA = value;
		}

		private String featuresU;

		public String getFeaturesU() {
			return featuresU;
		}

		public void setFeaturesU(String value) {
			this.featuresU = value;
		}

		private String featuresE;

		public String getFeaturesE() {
			return featuresE;
		}

		public void setFeaturesE(String value) {
			this.featuresE = value;
		}

		private String featuresG;

		public String getFeaturesG() {
			return featuresG;
		}

		public void setFeaturesG(String value) {
			this.featuresG = value;
		}

		private String featuresS;

		public String getFeaturesS() {
			return featuresS;
		}

		public void setFeaturesS(String value) {
			this.featuresS = value;
		}

		private String featuresN;

		public String getFeaturesN() {
			return featuresN;
		}

		public void setFeaturesN(String value) {
			this.featuresN = value;
		}

	}

	protected SCIDataImpl sCIData;

	private boolean initialized = false;

	public enum State {
		main_region_Init, main_region_Operate, main_region_Operate_AmbLight_AmbientLighting, main_region_Operate_SOSUI_SOSUI, main_region_Operate_EmergencyCall_EmergencyCall, main_region_Operate_GearAdvice_GearAdvice, main_region_Operate_StartStop_StartStop, main_region_Operate_Navigation_Navigation, $NullState$
	};

	private final State[] stateVector = new State[6];

	private int nextStateIndex;

	public ECU_CStatemachine() {

		sCInterface = new SCInterfaceImpl();
		sCIData = new SCIDataImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 6; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIData.setFeaturesA("");

		sCIData.setFeaturesU("");

		sCIData.setFeaturesE("");

		sCIData.setFeaturesG("");

		sCIData.setFeaturesS("");

		sCIData.setFeaturesN("");
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		enterSequence_main_region_default();
	}

	public void exit() {
		exitSequence_main_region();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$
				|| stateVector[2] != State.$NullState$ || stateVector[3] != State.$NullState$
				|| stateVector[4] != State.$NullState$ || stateVector[5] != State.$NullState$;
	}

	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	 * @see IStatemachine#isFinal()
	 */
	public boolean isFinal() {
		return false;
	}

	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {

	}

	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}

	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_Init :
				return stateVector[0] == State.main_region_Init;
			case main_region_Operate :
				return stateVector[0].ordinal() >= State.main_region_Operate.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_Operate_Navigation_Navigation.ordinal();
			case main_region_Operate_AmbLight_AmbientLighting :
				return stateVector[0] == State.main_region_Operate_AmbLight_AmbientLighting;
			case main_region_Operate_SOSUI_SOSUI :
				return stateVector[1] == State.main_region_Operate_SOSUI_SOSUI;
			case main_region_Operate_EmergencyCall_EmergencyCall :
				return stateVector[2] == State.main_region_Operate_EmergencyCall_EmergencyCall;
			case main_region_Operate_GearAdvice_GearAdvice :
				return stateVector[3] == State.main_region_Operate_GearAdvice_GearAdvice;
			case main_region_Operate_StartStop_StartStop :
				return stateVector[4] == State.main_region_Operate_StartStop_StartStop;
			case main_region_Operate_Navigation_Navigation :
				return stateVector[5] == State.main_region_Operate_Navigation_Navigation;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}
	public SCIData getSCIData() {
		return sCIData;
	}

	private boolean check_main_region_Init_tr0_tr0() {
		return true;
	}

	private void effect_main_region_Init_tr0() {
		exitSequence_main_region_Init();

		enterSequence_main_region_Operate_default();
	}

	/* Entry action for state 'Init'. */
	private void entryAction_main_region_Init() {
		sCIData.operationCallback.initFiat();
	}

	/* Entry action for state 'AmbientLighting'. */
	private void entryAction_main_region_Operate_AmbLight_AmbientLighting() {
		sCIData.operationCallback.operA();
	}

	/* Entry action for state 'SOSUI'. */
	private void entryAction_main_region_Operate_SOSUI_SOSUI() {
		sCIData.operationCallback.operU();
	}

	/* Entry action for state 'EmergencyCall'. */
	private void entryAction_main_region_Operate_EmergencyCall_EmergencyCall() {
		sCIData.operationCallback.operE();
	}

	/* Entry action for state 'GearAdvice'. */
	private void entryAction_main_region_Operate_GearAdvice_GearAdvice() {
		sCIData.operationCallback.operG();
	}

	/* Entry action for state 'StartStop'. */
	private void entryAction_main_region_Operate_StartStop_StartStop() {
		sCIData.operationCallback.operS();
	}

	/* Entry action for state 'Navigation'. */
	private void entryAction_main_region_Operate_Navigation_Navigation() {
		sCIData.operationCallback.operN();
	}

	/* 'default' enter sequence for state Init */
	private void enterSequence_main_region_Init_default() {
		entryAction_main_region_Init();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Init;
	}

	/* 'default' enter sequence for state Operate */
	private void enterSequence_main_region_Operate_default() {
		enterSequence_main_region_Operate_AmbLight_default();

		enterSequence_main_region_Operate_SOSUI_default();

		enterSequence_main_region_Operate_EmergencyCall_default();

		enterSequence_main_region_Operate_GearAdvice_default();

		enterSequence_main_region_Operate_StartStop_default();

		enterSequence_main_region_Operate_Navigation_default();
	}

	/* 'default' enter sequence for state AmbientLighting */
	private void enterSequence_main_region_Operate_AmbLight_AmbientLighting_default() {
		entryAction_main_region_Operate_AmbLight_AmbientLighting();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Operate_AmbLight_AmbientLighting;
	}

	/* 'default' enter sequence for state SOSUI */
	private void enterSequence_main_region_Operate_SOSUI_SOSUI_default() {
		entryAction_main_region_Operate_SOSUI_SOSUI();

		nextStateIndex = 1;
		stateVector[1] = State.main_region_Operate_SOSUI_SOSUI;
	}

	/* 'default' enter sequence for state EmergencyCall */
	private void enterSequence_main_region_Operate_EmergencyCall_EmergencyCall_default() {
		entryAction_main_region_Operate_EmergencyCall_EmergencyCall();

		nextStateIndex = 2;
		stateVector[2] = State.main_region_Operate_EmergencyCall_EmergencyCall;
	}

	/* 'default' enter sequence for state GearAdvice */
	private void enterSequence_main_region_Operate_GearAdvice_GearAdvice_default() {
		entryAction_main_region_Operate_GearAdvice_GearAdvice();

		nextStateIndex = 3;
		stateVector[3] = State.main_region_Operate_GearAdvice_GearAdvice;
	}

	/* 'default' enter sequence for state StartStop */
	private void enterSequence_main_region_Operate_StartStop_StartStop_default() {
		entryAction_main_region_Operate_StartStop_StartStop();

		nextStateIndex = 4;
		stateVector[4] = State.main_region_Operate_StartStop_StartStop;
	}

	/* 'default' enter sequence for state Navigation */
	private void enterSequence_main_region_Operate_Navigation_Navigation_default() {
		entryAction_main_region_Operate_Navigation_Navigation();

		nextStateIndex = 5;
		stateVector[5] = State.main_region_Operate_Navigation_Navigation;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region AmbLight */
	private void enterSequence_main_region_Operate_AmbLight_default() {
		react_main_region_Operate_AmbLight__entry_Default();
	}

	/* 'default' enter sequence for region SOSUI */
	private void enterSequence_main_region_Operate_SOSUI_default() {
		react_main_region_Operate_SOSUI__entry_Default();
	}

	/* 'default' enter sequence for region EmergencyCall */
	private void enterSequence_main_region_Operate_EmergencyCall_default() {
		react_main_region_Operate_EmergencyCall__entry_Default();
	}

	/* 'default' enter sequence for region GearAdvice */
	private void enterSequence_main_region_Operate_GearAdvice_default() {
		react_main_region_Operate_GearAdvice__entry_Default();
	}

	/* 'default' enter sequence for region StartStop */
	private void enterSequence_main_region_Operate_StartStop_default() {
		react_main_region_Operate_StartStop__entry_Default();
	}

	/* 'default' enter sequence for region Navigation */
	private void enterSequence_main_region_Operate_Navigation_default() {
		react_main_region_Operate_Navigation__entry_Default();
	}

	/* Default exit sequence for state Init */
	private void exitSequence_main_region_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state AmbientLighting */
	private void exitSequence_main_region_Operate_AmbLight_AmbientLighting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state SOSUI */
	private void exitSequence_main_region_Operate_SOSUI_SOSUI() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state EmergencyCall */
	private void exitSequence_main_region_Operate_EmergencyCall_EmergencyCall() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state GearAdvice */
	private void exitSequence_main_region_Operate_GearAdvice_GearAdvice() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}

	/* Default exit sequence for state StartStop */
	private void exitSequence_main_region_Operate_StartStop_StartStop() {
		nextStateIndex = 4;
		stateVector[4] = State.$NullState$;
	}

	/* Default exit sequence for state Navigation */
	private void exitSequence_main_region_Operate_Navigation_Navigation() {
		nextStateIndex = 5;
		stateVector[5] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_Init :
				exitSequence_main_region_Init();
				break;

			case main_region_Operate_AmbLight_AmbientLighting :
				exitSequence_main_region_Operate_AmbLight_AmbientLighting();
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case main_region_Operate_SOSUI_SOSUI :
				exitSequence_main_region_Operate_SOSUI_SOSUI();
				break;

			default :
				break;
		}

		switch (stateVector[2]) {
			case main_region_Operate_EmergencyCall_EmergencyCall :
				exitSequence_main_region_Operate_EmergencyCall_EmergencyCall();
				break;

			default :
				break;
		}

		switch (stateVector[3]) {
			case main_region_Operate_GearAdvice_GearAdvice :
				exitSequence_main_region_Operate_GearAdvice_GearAdvice();
				break;

			default :
				break;
		}

		switch (stateVector[4]) {
			case main_region_Operate_StartStop_StartStop :
				exitSequence_main_region_Operate_StartStop_StartStop();
				break;

			default :
				break;
		}

		switch (stateVector[5]) {
			case main_region_Operate_Navigation_Navigation :
				exitSequence_main_region_Operate_Navigation_Navigation();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region AmbLight */
	private void exitSequence_main_region_Operate_AmbLight() {
		switch (stateVector[0]) {
			case main_region_Operate_AmbLight_AmbientLighting :
				exitSequence_main_region_Operate_AmbLight_AmbientLighting();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region SOSUI */
	private void exitSequence_main_region_Operate_SOSUI() {
		switch (stateVector[1]) {
			case main_region_Operate_SOSUI_SOSUI :
				exitSequence_main_region_Operate_SOSUI_SOSUI();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region EmergencyCall */
	private void exitSequence_main_region_Operate_EmergencyCall() {
		switch (stateVector[2]) {
			case main_region_Operate_EmergencyCall_EmergencyCall :
				exitSequence_main_region_Operate_EmergencyCall_EmergencyCall();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region GearAdvice */
	private void exitSequence_main_region_Operate_GearAdvice() {
		switch (stateVector[3]) {
			case main_region_Operate_GearAdvice_GearAdvice :
				exitSequence_main_region_Operate_GearAdvice_GearAdvice();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region StartStop */
	private void exitSequence_main_region_Operate_StartStop() {
		switch (stateVector[4]) {
			case main_region_Operate_StartStop_StartStop :
				exitSequence_main_region_Operate_StartStop_StartStop();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region Navigation */
	private void exitSequence_main_region_Operate_Navigation() {
		switch (stateVector[5]) {
			case main_region_Operate_Navigation_Navigation :
				exitSequence_main_region_Operate_Navigation_Navigation();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Init. */
	private void react_main_region_Init() {
		effect_main_region_Init_tr0();
	}

	/* The reactions of state AmbientLighting. */
	private void react_main_region_Operate_AmbLight_AmbientLighting() {
	}

	/* The reactions of state SOSUI. */
	private void react_main_region_Operate_SOSUI_SOSUI() {
	}

	/* The reactions of state EmergencyCall. */
	private void react_main_region_Operate_EmergencyCall_EmergencyCall() {
	}

	/* The reactions of state GearAdvice. */
	private void react_main_region_Operate_GearAdvice_GearAdvice() {
	}

	/* The reactions of state StartStop. */
	private void react_main_region_Operate_StartStop_StartStop() {
	}

	/* The reactions of state Navigation. */
	private void react_main_region_Operate_Navigation_Navigation() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Init_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Operate_AmbLight__entry_Default() {
		enterSequence_main_region_Operate_AmbLight_AmbientLighting_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Operate_SOSUI__entry_Default() {
		enterSequence_main_region_Operate_SOSUI_SOSUI_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Operate_EmergencyCall__entry_Default() {
		enterSequence_main_region_Operate_EmergencyCall_EmergencyCall_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Operate_GearAdvice__entry_Default() {
		enterSequence_main_region_Operate_GearAdvice_GearAdvice_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Operate_StartStop__entry_Default() {
		enterSequence_main_region_Operate_StartStop_StartStop_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Operate_Navigation__entry_Default() {
		enterSequence_main_region_Operate_Navigation_Navigation_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Init :
					react_main_region_Init();
					break;
				case main_region_Operate_AmbLight_AmbientLighting :
					react_main_region_Operate_AmbLight_AmbientLighting();
					break;
				case main_region_Operate_SOSUI_SOSUI :
					react_main_region_Operate_SOSUI_SOSUI();
					break;
				case main_region_Operate_EmergencyCall_EmergencyCall :
					react_main_region_Operate_EmergencyCall_EmergencyCall();
					break;
				case main_region_Operate_GearAdvice_GearAdvice :
					react_main_region_Operate_GearAdvice_GearAdvice();
					break;
				case main_region_Operate_StartStop_StartStop :
					react_main_region_Operate_StartStop_StartStop();
					break;
				case main_region_Operate_Navigation_Navigation :
					react_main_region_Operate_Navigation_Navigation();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
