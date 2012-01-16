package angerona.fw.report;

import java.util.Date;

/**
 * A ReportEntry contains informations about a report, like the message, the poster or the attachment.
 * It also saves the simulation tick and the real time when the report was create.
 * @author Tim Janus
 */
public class ReportEntry implements Cloneable {
	private int 	simulationTick;
	
	private Date 	realTime;
	
	private String 	message;
	
	private ReportPoster poster;
	
	private ReportAttachment attachment;
	
	private ReportEntry() {}
	
	public ReportEntry(String message, ReportPoster poster, ReportAttachment attachment) {
		this.message = message;
		this.poster = poster;
		this.attachment = attachment;
		this.simulationTick = poster.getSimulationTick();
		this.realTime = new Date();
	}

	public int getSimulationTick() {
		return simulationTick;
	}

	public Date getRealTime() {
		return realTime;
	}

	public String getMessage() {
		return message;
	}

	public ReportPoster getPoster() {
		return poster;
	}

	public ReportAttachment getAttachment() {
		return attachment;
	}
	
	@Override
	public Object clone() {
		ReportEntry reval = new ReportEntry();
		reval.message = this.message;
		reval.simulationTick = this.simulationTick;
		reval.realTime = this.realTime;
		reval.poster = this.poster;
		if(this.attachment != null)
			reval.attachment = (ReportAttachment) this.attachment.clone();
		else 
			reval.attachment = null;
		return reval;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == this)						return true;
		if(! (other instanceof ReportEntry))	return false;
		
		ReportEntry cast = (ReportEntry)other;
		if(	cast.simulationTick == this.simulationTick && 
			cast.realTime == this.realTime &&
			cast.poster == this.poster ) {
			if(this.attachment == null && cast.attachment == null)	return true;
			else if(this.attachment != null && cast.attachment != null) {
				return this.attachment.getGUID() == cast.attachment.getGUID();
			}
		}
		return false;
	}
}