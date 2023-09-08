//
//  ComposeView.swift
//  iosContactsMP
//
//  Created by Hasan Cobanoglu on 9/8/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
struct ComposeView: UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
    }
    
    func makeUIViewController(context: Context) -> some UIViewController {
        MainViewControllerKt.MainViewController()
    }
}
