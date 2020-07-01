import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {ClientModel} from "../../models/ClientModel";
import Swal from 'sweetalert2'
import {ClientService} from "../../services/Client.Service";

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrls: ['./survey.component.css']
})
export class SurveyComponent implements OnInit {

  client = new ClientModel();

  score: string[] = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"];

  constructor(private clientService: ClientService) {
  }

  ngOnInit(): void {
  }

  save(f: NgForm) {
    if (f.invalid) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Debe ingresar todos los datos',
      });
      return;
    }
    Swal.fire({
      title: 'Esta seguro de enviar?',
      text: "Si cancela aun puede modificar sus respuestas!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, Enviar!'
    }).then((result) => {
      if (result.value) {
        this.clientService.createClient(this.client).subscribe(resp => {
          Swal.fire(
            'Enviado!',
            `Gracias ${resp.name} por su calificación`,
            'success'
          );
          f.resetForm();
        }, error => {
          console.log(error);
          Swal.fire(
            'Error!',
            `Gracias ${this.client.name} por su calificación, verificaremos el error`,
            'error'
          );
        });

      }
    })
  }


  clearForm(f: NgForm) {
    f.resetForm();
  }


}
