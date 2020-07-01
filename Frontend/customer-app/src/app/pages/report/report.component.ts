import {Component, OnInit} from '@angular/core';
import {ClientService} from "../../services/Client.Service";
import {ClientModel} from "../../models/ClientModel";

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  clientList: Object = [];

  constructor(private clientService: ClientService) {
  }

  ngOnInit(): void {
    this.loadList();
  }


  loadList() {
    this.clientService.getUsuarios().subscribe(resp => {
      console.log(resp);
      this.clientList = resp;
    }, error => {
      console.log(error);
    })
  }


}
