package com.bnsf.inventory.beans;

import java.io.Serializable;
import javax.persistence.*;
import org.springframework.stereotype.Component;
@Entity
@Table(name="Inventory")
public class InventoryItem implements Serializable {	
	@Id
    @SequenceGenerator(name="seq",sequenceName="seq")        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq") 
	@Column(name="Identifier2")
	private Integer Identifier2;

	@Column(name="EQPINIT")
	private String eqpInit;
	
	@Column(name="EQPNUMB")
	private Integer eqpNumb;
	
	@Column(name="STN333")
	private String stn333;
	
	@Column(name="STNST")
	private String stnSt;
	
	@Column(name="DEST333")
	private String dest333;
	
	@Column(name="DESTST")
	private String destSt;
	
	@Column(name="ETNTS")
	private String etnTs;
	
	@Column(name="EQPLGTH")
	private Integer eqpLgth;
	
	@Column(name="EQPWDTH")
	private Integer eqpWdth;
	
	@Column(name="EQPWEIGHT")
	private Integer eqpWeight;
	
	@Column(name="ECSID")
	private Integer ecsId;
	
	@Column(name="ECSPRCSD")
	private String ecsPrcsd;
	
	@Column(name="STATCD")
	private String statCd;

	@Override
	public String toString() {
		return "InventoryItem [Identifier12=" + Identifier2 + ", eqpInit=" + eqpInit + ", eqpNumb=" + eqpNumb
				+ ", stn333=" + stn333 + ", stnSt=" + stnSt + ", dest333=" + dest333 + ", destSt=" + destSt + ", etnTs="
				+ etnTs + ", eqpLgth=" + eqpLgth + ", eqpWdth=" + eqpWdth + ", eqpWeight=" + eqpWeight + ", ecsId="
				+ ecsId + ", ecsPrcsd=" + ecsPrcsd + ", statCd=" + statCd + "]";
	}

	public Integer getIdentifier2() {
		return Identifier2;
	}
	public void setIdentifier2(Integer Identifier2) {
		this.Identifier2 = Identifier2;
	}
	public String getEqpInit() {
		return eqpInit;
	}

	public void setEqpInit(String eqpInit) {
		this.eqpInit = eqpInit;
	}

	public Integer getEqpNumb() {
		return eqpNumb;
	}

	public void setEqpNumb(Integer eqpNumb) {
		this.eqpNumb = eqpNumb;
	}

	public String getStn333() {
		return stn333;
	}

	public void setStn333(String stn333) {
		this.stn333 = stn333;
	}

	public String getStnSt() {
		return stnSt;
	}

	public void setStnSt(String stnSt) {
		this.stnSt = stnSt;
	}

	public String getDest333() {
		return dest333;
	}

	public void setDest333(String dest333) {
		this.dest333 = dest333;
	}

	public String getDestSt() {
		return destSt;
	}

	public void setDestSt(String destSt) {
		this.destSt = destSt;
	}

	public String getEtnTs() {
		return etnTs;
	}

	public void setEtnTs(String etnTs) {
		this.etnTs = etnTs;
	}

	public Integer getEqpLgth() {
		return eqpLgth;
	}

	public void setEqpLgth(Integer eqpLgth) {
		this.eqpLgth = eqpLgth;
	}

	public Integer getEqpWdth() {
		return eqpWdth;
	}

	public void setEqpWdth(Integer eqpWdth) {
		this.eqpWdth = eqpWdth;
	}

	public Integer getEqpWeight() {
		return eqpWeight;
	}

	public void setEqpWeight(Integer eqpWeight) {
		this.eqpWeight = eqpWeight;
	}

	public Integer getEcsId() {
		return ecsId;
	}

	public void setEcsId(Integer ecsId) {
		this.ecsId = ecsId;
	}

	public String getEcsPrcsd() {
		return ecsPrcsd;
	}

	public void setEcsPrcsd(String ecsPrcsd) {
		this.ecsPrcsd = ecsPrcsd;
	}

	public String getStatCd() {
		return statCd;
	}

	public void setStatCd(String statCd) {
		this.statCd = statCd;
	}
	public InventoryItem() {
		super();
	}
	

	public InventoryItem(String eqpInit, Integer eqpNumb, String stn333, String stnSt, String dest333, String destSt,
			String etnTs, Integer eqpLgth, Integer eqpWdth, Integer eqpWeight, Integer ecsId, String ecsPrcsd, String statCd) {
		super();
		this.eqpInit = eqpInit;
		this.eqpNumb = eqpNumb;
		this.stn333 = stn333;
		this.stnSt = stnSt;
		this.dest333 = dest333;
		this.destSt = destSt;
		this.etnTs = etnTs;
		this.eqpLgth = eqpLgth;
		this.eqpWdth = eqpWdth;
		this.eqpWeight = eqpWeight;
		this.ecsId = ecsId;
		this.ecsPrcsd = ecsPrcsd;
		this.statCd = statCd;
	}

}
