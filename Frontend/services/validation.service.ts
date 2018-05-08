import { Injectable } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

@Injectable()
export class ValidationService {

  constructor() { }

  noNumbersandLowercaseValidator (control:FormControl){
    let allNumbers = /\d/g;
    let allUppercase = /[A-Z]/;
    if(!allNumbers.test(control.value)&&allUppercase.test(control.value)){
      return null;
    }else{
      return{noNumbersorLowercaseValidator:true};
    }
  }

  noNumbersValidator(control:FormControl){
    let allNumbers = /\d/g;
    if(!allNumbers.test(control.value)){
      return null;
    }else{
      return{noNumbersValidator:true}
    }

  }

  noLowercaseValidator(control:FormControl){
    let allUppercase = /[A-Z]/;
    if(allUppercase.test(control.value)){
      return null;
    }else{
      return{noLowercaseValidator:true}
    }
  }


  isAStateCodeValidator(item:string){
    let stateList = new Array("AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY");
    if(stateList.indexOf(item)==-1){
      return false;
    }else{
      return true;
    }

  }


}
