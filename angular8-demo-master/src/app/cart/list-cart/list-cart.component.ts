import { Component, OnInit } from '@angular/core';
import {Cart} from '../../model/cart.model';

@Component({
  selector: 'app-list-cart',
  templateUrl: './list-cart.component.html',
  styleUrls: ['./list-cart.component.css']
})
export class ListCartComponent implements OnInit {

  carts: Cart[];

  constructor() { }

  ngOnInit() {
  }

}
