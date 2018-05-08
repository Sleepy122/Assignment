import { Component, OnInit } from '@angular/core';
import { Inventory } from '../../entities/Inventory';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import {HttpServiceService} from '../../services/http-service.service';
import{ValidationService} from '../../services/validation.service'
 
//need a checkbox on each record
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  constructor(private modalService: NgbModal, private fb: FormBuilder,private http:HttpServiceService,private validation:ValidationService) {
    this.createAddForm();
  }

  public modalServiceRef;
  showOptions: boolean = false;
  public testing:Inventory[] =[];


  dummyData:Inventory[] = [];
  
  activeItem: Inventory = {
    identifier2:"",
    eqpInit: "fsaddfas",
    eqpNumb: 213,
    stn333: "jflds",
    stnSt: "jflds",
    dest333: "jflds",
    destSt: "jflds",
    etnTs: "jflds",
    eqpLgth: 67,
    eqpWdth: 3425,
    eqpWeight: 53,
    ecsId: 76,
    ecsPrcsd: "jflds",
    statCd: "jflds",
  };


  editRecordForm: FormGroup;
  deleteRecordForm: FormGroup;
  addRecordForm: FormGroup;

  createEditForm() {
    this.editRecordForm = this.fb.group({ // <-- the parent FormGroup
      eqpInit: [this.activeItem.eqpInit,[Validators.required,this.validation.noNumbersandLowercaseValidator]], 
      eqpNumb: this.activeItem.eqpNumb,
      stn333: this.activeItem.stn333,
      stnSt: this.activeItem.stnSt,
      dest333: this.activeItem.dest333,
      destSt: this.activeItem.destSt,
      etnTs: this.activeItem.etnTs,
      eqpLgth: this.activeItem.eqpLgth,
      eqpWdth: this.activeItem.eqpWdth,
      eqpWeight: this.activeItem.eqpWeight,
      ecsId: this.activeItem.ecsId,
      ecsPrcsd: this.activeItem.ecsPrcsd,
      statCd: this.activeItem.statCd,
    });
  }
  createAddForm() {
    this.addRecordForm = this.fb.group({ // <-- the parent FormGroup
      eqpInit: ["",Validators.compose([Validators.required,this.validation.noNumbersandLowercaseValidator])],
      eqpNumb: 0,
      stn333: "",
      stnSt: "",
      dest333: "",
      destSt: "",
      etnTs: "",
      eqpLgth: 0,
      eqpWdth: 0,
      eqpWeight: 0,
      ecsId: 0,
      ecsPrcsd: "",
      statCd: "",
    });
  }

  open(content) {
    this.modalService.open(content, { windowClass: 'fixed-modal' });
  }

  setShowOptions(value: boolean) {
    this.showOptions = value;
  }

  setActiveItem(value:Inventory){
    this.activeItem = value;
    this.createEditForm();
  }

  addItem(){
    console.log(this.addRecordForm.value);
    this.http.createInventory(this.addRecordForm.value);
    this.refreshDummy();
    location.reload();
  }
  setDummyData(items:Inventory[]){
    console.log(items);
    for(let i = 0; i<items.length; i++){
      this.dummyData[i] = items[i];
    }
  }
  refreshDummy(){
    this.http.getAllInventory().subscribe(result =>{
      console.log(result);
      this.testing = result;
      this.setDummyData(this.testing);
    });
  }

  deleteItem(){
    console.log(this.activeItem.identifier2);
    this.http.deleteInventory(this.activeItem.identifier2);
    location.reload();
  }

  editItem(item:Inventory){
   var temp =  this.activeItem.identifier2
    this.activeItem = this.editRecordForm.value; 
    this.activeItem.identifier2 = temp;
    console.log(this.editRecordForm.value.stn333);
    this.http.updateInventory(this.activeItem);
    location.reload();
  }



  ngOnInit() {
    //this.dummyData = [this.item1,this.item2];
    this.refreshDummy();
    console.log(this.addRecordForm.errors);
  }



}
