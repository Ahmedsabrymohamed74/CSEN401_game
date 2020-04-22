package model.units;

import exceptions.CannotTreatException;
import exceptions.IncompatibleTargetException;
import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import simulation.Address;

public class FireTruck extends FireUnit {

	public FireTruck(String unitID, Address location, int stepsPerCycle,
			WorldListener worldListener) {
		super(unitID, location, stepsPerCycle, worldListener);
	}

	@Override
	public void treat() throws CannotTreatException, IncompatibleTargetException {
		getTarget().getDisaster().setActive(false);

		ResidentialBuilding target = (ResidentialBuilding) getTarget();
		
			if(getTarget() instanceof Citizen)
				throw new IncompatibleTargetException(this, target, "Incompatible Target");
			
		if(canTreat(target)==true){
		
		if (target.getStructuralIntegrity() == 0) {
			jobsDone();
			return;
		} else if (target.getFireDamage() > 0)

			target.setFireDamage(target.getFireDamage() - 10);

		if (target.getFireDamage() == 0)

			jobsDone();
		}
		else
			throw new CannotTreatException(this, target, "cannot treat");

	
	if(!(target instanceof ResidentialBuilding))
		throw new IncompatibleTargetException(this, target, "Incompatible Target");
	}
}
