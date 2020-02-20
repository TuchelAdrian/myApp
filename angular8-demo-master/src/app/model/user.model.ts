import {Cart} from './cart.model';

export class User {

  id: number;
  name: string;
  password: string;
  email: string;
  phone: string;
  address: string;
  cart: Cart;
}
