import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdersListService {

  apiUrl: string="http://localhost:8080/api/orders"

  apiUrlChangeStatus: string="http://localhost:8080/change-status"

  constructor(
    private httpClient: HttpClient
  ) { }

  // addToCart(item : any, qty: number): void {
  //   let {menu_id} = item
  //   let {price} = item
  //   let cartItems = this.cart[menu_id]
  //   if (!cartItems) {
  //     cartItems = {item, quantity: qty}
  //     this.total += price
  //   }
  //   else {
  //     cartItems = {...cartItems, quantity:cartItems.quantity + qty}
  //     this.total += price * qty
  //   }
  //   if(cartItems.quantity === 0) {
  //     delete this.cart[menu_id];
  //     this.total = 0
  //   }
  //   else {
  //     this.cart[menu_id] = cartItems;
  //   }
  //     console.log(this.cart)
  //     console.log(this.total)
  //     this.cartStream.next(this.cart)
  // }

  // cartStream = new BehaviorSubject<any>([])

  // private data$: Observable<string>

  getOrders(status: string): any {
      // return this.cartStream.next(this.httpClient.get(`${this.apiUrl}/${status}`))
      return this.httpClient.get(`${this.apiUrl}/${status}`)
    }

  acceptOrder(order_id: number) {
    console.log("order_id" + order_id)
    return this.httpClient.patch(`${this.apiUrlChangeStatus}/${order_id}`, {"orderStatus": "ACCEPTED"})
  }

  denyOrder(order_id: number) {
    console.log("order_id" + order_id)
    return this.httpClient.patch(`${this.apiUrlChangeStatus}/${order_id}`, {"orderStatus": "DENIED"})
  }

}