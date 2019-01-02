package com.data.orm.entity;
import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus_fare")
public class GeneralServiceFares {

	
		
		@Id
		@Column(name = "fare_stage_number")
		private int mFareStageNumber;
		
		@Column(name = "adult")
		private float mAdult;
		
		@Column(name = "child")
		private float mChild;
		
		@Column(name = "senior_citizen")
		private float mSeniorCitizen;
		
		
		@Column(name = "created_on", columnDefinition="DATETIME")
		private Date createdOn;

		
		public int getmFareStageNumber() {
			return mFareStageNumber;
		}

		public void setmFareStageNumber(int mFareStageNumber) {
			this.mFareStageNumber = mFareStageNumber;
		}

		public float getmAdult() {
			return mAdult;
		}

		public void setmAdult(float mAdult) {
			this.mAdult = mAdult;
		}

		public float getmChild() {
			return mChild;
		}

		public void setmChild(float mChild) {
			this.mChild = mChild;
		}

		public float getmSeniorCitizen() {
			return mSeniorCitizen;
		}

		public void setmSeniorCitizen(float mSeniorCitizen) {
			this.mSeniorCitizen = mSeniorCitizen;
		}
		public Date getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(Date createdOn) {
			this.createdOn = createdOn;
		}
	}

