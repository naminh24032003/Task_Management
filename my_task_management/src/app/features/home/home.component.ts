import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  companyLogos = [
    'IBM',
    'DATADOG',
    'SIEMENS',
    'AT&T',
    'AMERICAN AIRLINES',
    'CN',
    'SEPHORA',
    'REMAX',
    'WAYFAIR',
    'LOGITECH'
  ];
}