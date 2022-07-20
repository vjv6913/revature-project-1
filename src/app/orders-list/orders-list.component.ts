import { Component, OnInit } from '@angular/core';
import { OrdersListService } from '../orders-list.service';

@Component({
  selector: 'app-orders-list',
  templateUrl: './orders-list.component.html',
  styleUrls: ['./orders-list.component.css']
})
export class OrdersListComponent implements OnInit {

  orders: any = {}

  constructor(
    private orderListService: OrdersListService 
  ) { }

  ngOnInit(): void {
    // this.loadOrdersList()
    this.orderListService.getOrders("pending")
    .subscribe((requests: any) => {
      this.orders = requests
    })
  }

  // loadOrdersList() {
  //   this.orderListService.getOrders("pending")
  //   .subscribe({
  //     next:(response:any) => {
  //       this.orders = response
  //       console.log(this.orders)
  //     },
  //     error: (err: any) => {
  //       console.log(err)
  //     }
  //   })
  // }

}
