import { Component } from '@angular/core';
import {AppService} from './app.service';
import { ViewEncapsulation } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent {

  constructor(private _service: AppService) {
  }
  displayVehicle = false;
  vehicleList: any = [];
  getTrucks() {
    this.displayVehicle = true;
    this._service
    .getTruckList()
      .subscribe(res => {
      this.vehicleList = res;
    });
  }
}
