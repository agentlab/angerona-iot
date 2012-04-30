package angerona.fw;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import angerona.fw.internal.IdGenerator;

public class MasterPlan extends Subgoal implements AgentComponent {

	private Long id;
	
	private Long parent;
	
	public MasterPlan() {
		super((Agent)null);
		id = IdGenerator.generate(this);
	}
	
	public MasterPlan(MasterPlan plan) {
		super(plan);
		id = plan.getGUID();
		parent = plan.getParent();
	}

	@Override
	public void onSubgoalFinished(Intention subgoal) {
		super.onSubgoalFinished(subgoal);

		Angerona.getInstance().report("Step on plan executed, plan updated.", getAgent().getEnvironment(), (MasterPlan)this);
	}
	
	@Override
	public Long getGUID() {
		return id;
	}

	@Override
	public Long getParent() {
		return parent;
	}

	@Override
	public List<Long> getChilds() {
		return new LinkedList<Long>();
	}

	@Override
	public Object clone() {
		return new MasterPlan(this);
	}

	@Override
	public void init(Map<String, String> additionalData) {
		// nothing...
	}

	@Override
	public void setParent(Long id) {
		parent = id;
		agent = (Agent)IdGenerator.getEntityWithId(id);
	}
}
